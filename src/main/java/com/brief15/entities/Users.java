package com.brief15.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="full_name", nullable=false, length=50)
	private String fullName;
	
	@Column(name="phone", nullable=false, length=50)
	private String phone;
	
	@Column(name="email", nullable=false, length=50)
	private String email;
	
	@Column(name="user_name", nullable=false, length=50)
	private String login; 
	//private String userName;
	
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name="password", nullable=false, length=200)
	private String password;
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "users_permissions",
                joinColumns = @JoinColumn( name = "user_id" ),
                inverseJoinColumns = @JoinColumn( name = "permission_id" ) )
    private Set<Permission> permissions;
	
	
	@OneToMany(mappedBy="client")
	private Set<Order> orders;
	
}