package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends UserDetails{
  @Id
  @GeneratedValue
  private int adminID;
  private String office;

  public int getAdminID() {
      return this.adminID;
  }

  public void setAdminID(int adminID) {
      this.adminID = adminID;
  }

  public String getOffice() {
      return this.office;
  }

  public void setOffice(String office) {
      this.office = office;
  }

}
