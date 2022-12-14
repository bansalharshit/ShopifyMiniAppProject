package com.masai.Model;


import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDto {
	
		//In order to transfer ADMIN object.
		//Mostly used to login purposes.
		//if needed for update
		
		@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$"
				,message ="Provide a Valid Mobile Number !")
		@JoinColumn(name = "Mobile No.")
		private String mobileNo;
		
		@NotNull(message = "Password is mandatory")
		@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",
		message = "Password must be of 8 characters and must include "
				+ " at least one upper case English letter, one lower case "
				+ "English letter, one number and one special character.")
		@JoinColumn(name = "Password")
		private String password;

//		public String getMobileNo() {
//			return mobileNo;
//		}
//
//		public void setMobileNo(String mobileNo) {
//			this.mobileNo = mobileNo;
//		}
//
//		public String getPassword() {
//			return password;
//		}
//
//		public void setPassword(String password) {
//			this.password = password;
//		}
//
//		public AdminDto(
//				@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Provide a Valid Mobile Number !") String mobileNo,
//				@NotNull(message = "Password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Password must be of 8 characters and must include  at least one upper case English letter, one lower case English letter, one number and one special character.") String password) {
//			super();
//			this.mobileNo = mobileNo;
//			this.password = password;
//		}
//
//		
//		
//		public AdminDto() {
//			super();
//		}
//
//		@Override
//		public String toString() {
//			return "AdminDto [mobileNo=" + mobileNo + ", password=" + password + "]";
//		}
		
		
		
	
}
