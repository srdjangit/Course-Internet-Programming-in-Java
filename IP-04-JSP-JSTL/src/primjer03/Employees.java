/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primjer03;

/**
 *
 * @author mlatinovic
 */
public class Employees {

    protected String firstName;
    protected String lastName;
    protected String address;
    
    public void setAddress(String address) {
        this.address = address;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
}

