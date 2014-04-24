CREATE TABLE tbluser
(
  cid serial NOT NULL,
  name character varying(200),
  isadmin boolean NOT NULL,
  password character varying(100),
  email character varying(100),
  lastloginfaildate timestamp without time zone,
  lastlogintime timestamp without time zone,
  ispwdexpired boolean DEFAULT false,
  prevlogintime timestamp without time zone,
  issystemdisabled boolean DEFAULT false,
  ipaddress character varying(30),
  issystempassword boolean DEFAULT false,
  signupuser boolean DEFAULT false,
  deleted boolean DEFAULT false,
  CONSTRAINT tbluser_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbluser_name_key UNIQUE (name )
)

CREATE TABLE tblrole
(
  cid serial NOT NULL,
  name character varying(50),
  lastupdatedon timestamp without time zone,
  isprivate boolean DEFAULT false,
  system boolean DEFAULT false,
  description character varying,
  CONSTRAINT tblrole_pkey PRIMARY KEY (cid ),
  CONSTRAINT tblrole_name_key UNIQUE (name )
)

CREATE TABLE tbl_user_roles
(
  cid serial NOT NULL,
  userid integer NOT NULL,
  roleid integer NOT NULL,
  CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbl_user_roles_fk_1 FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_user_roles_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE tblaccessrights
(
  cid serial NOT NULL,
  parentid integer,
  description character varying(125),
  code character varying(50),
  enabled boolean NOT NULL DEFAULT true,
  itemorder character varying(250),
  servicecode character varying(500),
  isold boolean DEFAULT false,
  isprivate boolean DEFAULT false,
  isadmin boolean DEFAULT false,
  isemployee boolean DEFAULT false,
  ismanager boolean DEFAULT false,
  CONSTRAINT fk_tblfeatures_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_role_features_fk_1 FOREIGN KEY (parentid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblaccessrights_code_key UNIQUE (code )
)

CREATE TABLE tbl_role_accessrights
(
  cid serial NOT NULL,
  roleid integer NOT NULL,
  featureid integer NOT NULL,
  read_write_access boolean DEFAULT false,
  CONSTRAINT tbl_role_accessrights_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbl_role_accessrights_fk_1 FOREIGN KEY (featureid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_role_accessrights_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_tbl_role_accessrights_role_feature UNIQUE (roleid , featureid )
)


create table tblcategorytype(cid serial not null, description varchar(200), code varchar(500), 
constraint pk_tblcategorytype primary key(cid));

create table tblcategoryitem(cid serial not null, description varchar(200), type integer 
references tblcategorytype(cid), constraint pk_tblcategoryitem primary key(cid));

insert into tbluser(name,isadmin,password,email) values('superuser',true,'sa','rathordeepak1985@yahoo.in')

insert into tbluser(name,isadmin,password,email) values('manager',true,'sa','rathordeepak1985@yahoo.in')

insert into tbluser(name,isadmin,password,email) values('employee',true,'sa','rathordeepak1985@yahoo.in')

insert into tblrole(name,description) values('admin','Administrator')

insert into tblrole(name,description) values('Manager','Manager')

insert into tblrole(name,description) values('employee','Employee')

insert into tbl_user_roles(userid,roleid) values(1,1);

insert into tbl_user_roles(userid,roleid) values(2,2);

insert into tbl_user_roles(userid,roleid) values(3,3);

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Home Page','pg_home',true,true,true,true)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Admin Page','pg_adm_home',true,true,false,false)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Manager Page','pg_mgr_home',true,true,false,true)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Employee Page','pg_emp_home',true,true,true,false)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,2,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,3,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(2,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(2,2,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(3,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(3,3,true)
