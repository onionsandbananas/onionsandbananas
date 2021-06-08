package com.jpo.kd.biblioteka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="login")
		private String login;
		
		@Column(name="password")
		private String password;
		
		@Column(name="ui")
		private int ui;
		
		@Column(name="role")
		private String role;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getUi() {
			return ui;
		}

		public void setUi(int ui) {
			this.ui = ui;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}	
}
