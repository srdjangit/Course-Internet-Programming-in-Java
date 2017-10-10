/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phaseListeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import controller.UserController;

/**
 *
 * @author milan.latinovic
 */
@SuppressWarnings("deprecation")
public class IsAdminCheck implements PhaseListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    public void beforePhase(PhaseEvent event) {
    }

    public void afterPhase(PhaseEvent event) {
    	System.out.println("Zavrsena faza");
        FacesContext fc = event.getFacesContext();

        // Da li korisnik trazi /admin/ ?
        boolean adminPage = fc.getViewRoot().getViewId().lastIndexOf("/app-admin/") > -1 ? true : false;
        // Da li je logovan kao admin ?
        UserController uc = (UserController) getBean("userController");
        if (adminPage && !uc.getLoggedUser().getAccountType().equalsIgnoreCase("admin")) {
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "adminLoginFalse");
            System.out.println("Nedozvoljen prilaz");
        }
    }

    private Object getBean(String beanReference){
        ValueBinding vb = FacesContext.getCurrentInstance().getApplication().createValueBinding("#{"+ beanReference + "}");
        return vb.getValue(FacesContext.getCurrentInstance());
    }

}
