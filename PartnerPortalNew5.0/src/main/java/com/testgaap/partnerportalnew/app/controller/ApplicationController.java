package com.testgaap.partnerportalnew.app.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.testgaap.partnerportalnew.app.entity.OrderEntity;
import com.testgaap.partnerportalnew.app.email.MailService;
import com.testgaap.partnerportalnew.app.email.MailServiceImpl;
import com.testgaap.partnerportalnew.app.model.OrderHistory;
import com.testgaap.partnerportalnew.app.model.User;
import com.testgaap.partnerportalnew.app.repository.OrderHistoryRepository;
import com.testgaap.partnerportalnew.app.service.CustomUserDetails;
import com.testgaap.partnerportalnew.app.service.OrderHistoryService;

@RestController
@RequestMapping("/")
public class ApplicationController {

	private static String UPLOAD_FOLDER = "C://Users//ganan//Desktop//SpringBoot//uploadedfile//";

	@Autowired
	public MailServiceImpl mailservice;

	@Autowired
	public OrderHistoryService ohService;

	@Autowired
	public OrderHistoryRepository ohRepository;

	@GetMapping("/process")
	public String process() {
		return "process....";
	}

	// ---------------Display Upload
	// File--------------------------------------------

	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload.jsp");
	}

	// ----------------Upload
	// file---------------------------------------------------

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			return new ModelAndView("status.jsp", "message", "Please select a file and try again");
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("status.jsp", "message", "Order has been upoaded sucessfully");
		
		
	}
	
	
	ModelAndView mv = new ModelAndView("order.jsp");
	
	
	
	

	private static final String EXTERNAL_FILE_PATH = "C:\\Users\\ganan\\Desktop\\SpringBoot\\uploadedfile\\";

	// ----Downloading
	// File--------------------------------------------------------------

	@RequestMapping("/file/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {

		File file = new File(EXTERNAL_FILE_PATH + fileName);
		if (file.exists()) {

			// get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				// unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);

			/**
			 * In a regular HTTP response, the Content-Disposition response header is a
			 * header indicating if the content is expected to be displayed inline in the
			 * browser, that is, as a Web page or as part of a Web page, or as an
			 * attachment, that is downloaded and saved locally.
			 * 
			 */

			/**
			 * Here we have mentioned it to show inline
			 */
			// response.setHeader("Content-Disposition", String.format("inline; filename=\""
			// + file.getName() + "\""));

			// Here we have mentioned it to show as attachment
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}

	@RequestMapping("/home")
	public ModelAndView status() {

		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;
	}
	@RequestMapping("/")
	public ModelAndView homestatus() {
		
		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;
	}

	@GetMapping("/registration")
	public ModelAndView registration() {

		ModelAndView mv = new ModelAndView("registration.jsp");
		return mv;
	}

	// --------To display Forgot password jsp page----------------------
	@GetMapping("/forgotUserNameandPassword")
	public ModelAndView forgotUserNameandPassword() {
		ModelAndView mv = new ModelAndView("forgotUserNameandPassword.jsp");
		return mv;
	}

	// -----To send email to reseller to reset password-----------------------
	@GetMapping("/forgotusernameandpassword")
	public String forgotusernameandpassword(
			@RequestParam("forgotusernameandpassword") String forgotusernameandpassword) {
		try {
			mailservice.send(forgotusernameandpassword, "gautamtest23082017@gmail.com", "hi", "just to check again");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return "Link to change password has been sent to your email address";

	}

	// -------Changing password--------------

	// -------------------- accessing order history page
	// ------------------------------------

	@GetMapping("/orderhistory/{account_no}")
	public List<OrderHistory> getOrderHistoryByAccountNo(@PathVariable long account_no)
	{
		return ohService.findOrderHistoryByAccountNo(account_no);
	}
	
	

	@PostMapping("/orderhistory")
	public String addUserByAdmin(@RequestBody OrderHistory orderhistory) {

		ohRepository.save(orderhistory);
		return "orderhistory added successfully...";
	}
	
	
	
	@GetMapping("/orderhistory")
	public List<OrderHistory> getOrderHistory(Authentication authentication)
	{
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		return ohService.findOrderHistoryByAccountNo(userDetails.getUser().getAccount_no());
	}
	
	
	@GetMapping("/logout-success")
	public ModelAndView logoutSuccessful()
	{
		ModelAndView mv = new ModelAndView("logout.jsp");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView loginPage()
	{
		ModelAndView mv = new ModelAndView("login.jsp");
		return mv;
	}
	
	
	

}
