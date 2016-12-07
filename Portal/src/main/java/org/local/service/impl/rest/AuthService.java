package org.local.service.impl.rest;

import java.util.UUID;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.context.SpringUtil;

import org.model.User;
import org.userBO.UserBO;
import org.auth.AuthServiceInterface;
import org.authenticater.AuthenticaterImpl;

@Produces("text/plain")
public class AuthService implements AuthServiceInterface {

	private static final Logger logger = Logger.getLogger(AuthService.class);
	private String token = null;

	@GET
	@Path(value = "authService")
	public String AuthService1(@QueryParam("param1") String p1,
			@QueryParam("param2") String p2) throws Exception {
		
		logger.info("Request to Authenticate service is: "+p1 + " " +p2);

		if (p1 == null || p2 == null) {

			return "Either Username or Password is not provided";
		} else {

			token=AuthenticaterImpl.getInstance().authenticate(p1, p2);
			if(token==null){
				return "Invalid Username or Password";
			}
			else{
				return "Valid Username and Password, Authentication Successfull";
			}

		}

		// logger.info("Request to Authenticate service is: "+p1 + " " +p2);
		// UserBO userBO1 =
		// (UserBO)SpringUtil.getInstance().getBeanById("userBo");
		//
		// User user2 = userBO1.findByUserName(p1);
		// if(user2.pwd.equals(p2))
		// {
		// return "The User is authenticated";
		// }
		// else
		// {
		// return "The User is not authenticated";
		// }
	}

}
