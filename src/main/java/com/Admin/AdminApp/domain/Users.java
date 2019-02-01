package com.Admin.AdminApp.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SqlResultSetMapping(
		name="usersOnHPMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=UsersOnHP.class,
	            columns={
	                @ColumnResult(name="USER_NAME", type = String.class),
	                @ColumnResult(name="PHONE", type = String.class),
	                @ColumnResult(name="ROLE_NAME", type = String.class),
	                @ColumnResult(name="LOGIN", type = String.class)

	            }
	        )
	    }
	)
 @NamedNativeQuery(name="Users.getUsersOnHP",
        query="SELECT USERS.USER_NAME , USERS.PHONE, ROLE.ROLE_NAME, USERS.LOGIN " + 
 		" FROM USERS " + 
 		"INNER JOIN USER_ROLE ON USERS.USER_ID=USER_ROLE.USER_ID " + 
 		"INNER JOIN ROLE ON ROLE.ROLE_ID=USER_ROLE.ROLE_ID",
 		resultSetMapping="usersOnHPMapping")
 
@SqlResultSetMapping(
		name="UsersRoleArrayMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=UserRoleArray.class,
	            columns={
	                @ColumnResult(name="ROLE_NAME", type = String.class)

	            }
	        )
	    }
	)
 @NamedNativeQuery(name="Users.getUsersRoleArray",
        query="SELECT ROLE.ROLE_NAME " + 
 		" FROM USERS " + 
 		" INNER JOIN USER_ROLE ON USERS.USER_ID=USER_ROLE.USER_ID " + 
 		" INNER JOIN ROLE ON ROLE.ROLE_ID=USER_ROLE.ROLE_ID " +
 		" WHERE((USERS.USER_ID)=:userid) ",resultSetMapping="UsersRoleArrayMapping")

@SqlResultSetMapping(
		name="UsersWithRoleMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=UsersWithRole.class,
	            columns={
	                @ColumnResult(name="USER_NAME", type = String.class),
	                @ColumnResult(name="PHONE", type = String.class),
	                @ColumnResult(name="ROLESALL", type = String.class),
	                @ColumnResult(name="LOGIN", type = String.class)
	            }
	        )
	    }
	)
@NamedNativeQuery(name="Users.getUsersWithRole",
query=" SELECT u.USER_NAME , u.PHONE , (SELECT STRING_AGG(ROLE.ROLE_NAME , ' / ' ) " + 
		" from USERS join USER_ROLE on USERS.USER_ID =USER_ROLE.USER_ID " + 
		" join ROLE on ROLE.ROLE_ID =USER_ROLE.ROLE_ID " + 
		"  where USERS.USER_ID =u.USER_ID ) as ROLESALL ,u.LOGIN " + 
		" from USERS u " + 
		" join USER_ROLE ur on u.USER_ID =ur.USER_ID " + 
		"  join ROLE ro on ro.ROLE_ID =ur.ROLE_ID " + 
		" group by  u.USER_NAME ,u.USER_ID, u.PHONE , u.LOGIN ",
	resultSetMapping="UsersWithRoleMapping")

public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long UserId;
	@Column(unique=true)
	private String UserName;
	private String Phone;
	private String Name;
	private String Password;
	private String login;
	
    
	 @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "UserId"),
    inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "RoleId"))
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	 private Set<Role> roles;
    public Set<Role> getRoles() {
		return roles;
	}

	public long getUserId() {
		return UserId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Users() {
		super();
	}

	public Users(String userName_gmail, String phone, String name, String password, Set<Role> roles) {
		super();
		UserName = userName_gmail;
		Phone = phone;
		Name = name;
		Password = password;
		this.roles = roles;
	}

	
	public Users(String userName_gmail, String phone, String name, String password) {
		super();
		UserName = userName_gmail;
		Phone = phone;
		Name = name;
		Password = password;
	}

	public Users(String userName, String phone, String name, String password, String login, Set<Role> roles) {
		super();
		UserName = userName;
		Phone = phone;
		Name = name;
		Password = password;
		this.login = login;
		this.roles = roles;
	}

	public String getUserName_gmail() {
		return UserName;
	}

	public void setUserName_gmail(String userName_gmail) {
		UserName = userName_gmail;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
