package com.accenture.insurance.controllers;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;





@RestController
public class DriveController {

	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	private static JsonFactory JSON_FACTORY=JacksonFactory.getDefaultInstance();
		
	private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE,
			"https://www.googleapis.com/auth/drive.install");
	
	private static final String USER_IDENTIFIER_KEY= "MY_DUMMY_USER";
	
	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;
	
	@Value("${google.secret.key.path}")
	private Resource gdSecretKeys;
	
	@Value("${google.credentials.folder.path}")
	private Resource credentialsFolder;
	
	private GoogleAuthorizationCodeFlow flow;
	
	@PostConstruct
	public void init() throws Exception{
		GoogleClientSecrets secrets=GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(gdSecretKeys.getInputStream()));
		flow=new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, secrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(credentialsFolder.getFile())).build();
	} 
	
	@GetMapping(value= "/drive")
	public String showHomePage() throws Exception {
		boolean isUserAuthenticated =false;
		Credential credential=flow.loadCredential(USER_IDENTIFIER_KEY);
		if(credential!=null) {
			boolean tokenValid =credential.refreshToken();
			if(tokenValid) {
				isUserAuthenticated=true;
			}
		}
		
		return isUserAuthenticated?"dashboard.html":"index.html";
		}
	@GetMapping(value= "/drive/googlesignin")
	public void doGoogleSignIn(HttpServletResponse response) throws Exception {
		GoogleAuthorizationCodeRequestUrl url= flow.newAuthorizationUrl();
		String redirectURL= url.setRedirectUri(CALLBACK_URI).setAccessType("offline").build();
		response.sendRedirect(redirectURL);
	}
	@GetMapping(value= "/drive/oauth")
	public String saveAuthorizationCode (HttpServletRequest request) throws Exception{
		String code=request.getParameter("code");
		if(code!=null) {
			saveToken(code);
			
			return "dashboard.html";
		}
		
		return "index.html";
	}
	private void saveToken(String code)throws Exception{
		GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(CALLBACK_URI).execute();
		flow.createAndStoreCredential(response, USER_IDENTIFIER_KEY);
	}
	
	@GetMapping(value= "/drive/create")
	public void createFile (HttpServletResponse response) throws Exception{
		Credential cred=flow.loadCredential(USER_IDENTIFIER_KEY);
		Drive drive=new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, cred).setApplicationName("googleDriveSpringBootExample").build();
		
		File file=new File();
		file.setName("profile.jpg");
		
		FileContent content=new FileContent("image/jpeg", new java.io.File("sample.jpg"));
		File uploadedFile= drive.files().create(file, content).setFields("id").execute();
		
		String fileRefere=String.format("{fileID '%s'}", uploadedFile.getId());
		response.getWriter().write(fileRefere);
	}
	@GetMapping(value="/drive/list-files", produces="application/json")
	public List<File> listFiles() throws Exception{
		Credential cred=flow.loadCredential(USER_IDENTIFIER_KEY);
		
		Drive drive=new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, cred).setApplicationName("googleDriveSpringBootExample").build();

		List<File> fList = new ArrayList<>();
		
		FileList fileList=drive.files().list().setFields("files(id,name)").execute();
		for(File file : fileList.getFiles()) {
			File item=new File();
			item.setId(file.getId());
			item.setName(file.getName());
			item.setThumbnailLink(file.getThumbnailLink());
			fList.add(item);
		}
		return fList;
		
	}
	@DeleteMapping(value="/drive/deletefile/{fileId}",produces="application/json")
	public Message deleteFile(@PathVariable(name="fileId")String fileId) throws Exception {
		Credential cred=flow.loadCredential(USER_IDENTIFIER_KEY);
		
		Drive drive=new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, cred).setApplicationName("googleDriveSpringBootExample").build();
		
		drive.files().delete(fileId).execute();
	
		Message message= new Message();
		message.setMessage("File has been deleted");
		return message;
		
	}
	
	class Message{
		private String message;
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message=message;
		}
	}
}
