package com.springmvc.model;

public class UserBean {
	
	   private long id;
	     
	    private String username;
	     
	    private String address;
	     
	    private String email;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "UserBean [id=" + id + ", username=" + username
					+ ", address=" + address + ", email=" + email + "]";
		}
	    

}
