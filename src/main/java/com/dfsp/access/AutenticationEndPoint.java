package com.dfsp.access;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dfsp.resource.user.UserDAO;

@Path("/auth")
public class AutenticationEndPoint {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("email") String email, @FormParam("password") String password) {
		String token = null;
		try {

			if (authenticate(email, password) != false) {
				token = issueToken(email);
			}
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	private boolean authenticate(String email, String password) throws Exception {

		boolean result = false;
		if (UserDAO.checkUserEmail(email) == true) {
			System.out.println("AuthenticateEndPoint email: OK");
			try {
				String passwordStored = UserDAO.getPassword(email);
				if (PasswordAuth.checkUserPassword(password, passwordStored) == true) {
					result = true;
					System.out.println("AuthenticateEndpoint password: OK");
				} else {
					result = false;
					System.out.println("AuthenticateEndPoint password: ERROR");
				}
			} catch (Exception e) {

			}
		} else {
			System.out.println("AuthenticateEndPoint email: NOT EXIST");
		}
		return result;
	}

	private String issueToken(String username) {

		String token = UUID.randomUUID().toString() + ":" + System.currentTimeMillis();
		// String[] t = token.split(":");
		// String token_time = t[1];
		System.out.println("TOKEN: " + token);
		return token;
	}

}
