package pl.pawelfrydrych.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class BookUtil {
	public static void redirect(String file) {
		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

			Flash flash = context.getFlash();
			flash.setKeepMessages(true);

			context.redirect(context.getRequestContextPath() + "/" + file + "?faces-redirect=true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
