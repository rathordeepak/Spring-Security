CREATE TABLE fk_tbluser
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
  theme character varying(25),
  deleted boolean DEFAULT false,
  CONSTRAINT fk_tbluser_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_tbluser_name_key UNIQUE (name )
)

CREATE TABLE fk_tblrole
(
  cid serial NOT NULL,
  name character varying(50),
  lastupdatedon timestamp without time zone,
  isprivate boolean DEFAULT false,
  system boolean DEFAULT false,
  description character varying,
  CONSTRAINT fk_tblrole_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_tblrole_name_key UNIQUE (name )
)

CREATE TABLE fk_user_roles
(
  cid serial NOT NULL,
  userid integer NOT NULL,
  roleid integer NOT NULL,
  CONSTRAINT fk_user_roles_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_user_roles_fk_1 FOREIGN KEY (userid)
      REFERENCES fk_tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_user_roles_fk_2 FOREIGN KEY (roleid)
      REFERENCES fk_tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE fk_tblfeatures
(
  cid serial NOT NULL,
  parentid integer,
  description character varying(125),
  code character varying(50),
  enabled boolean NOT NULL DEFAULT true,
  itemorder character varying(250),
  modulename character varying(100),
  servicecode character varying(500),
  isold boolean DEFAULT false,
  isprivate boolean DEFAULT false,
  isadmin boolean DEFAULT false,
  isemployee boolean DEFAULT false,
  ismanager boolean DEFAULT false,
  CONSTRAINT fk_tblfeatures_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_role_features_fk_1 FOREIGN KEY (parentid)
      REFERENCES fk_tblfeatures (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tblfeatures_code_key UNIQUE (code )
)

CREATE TABLE fk_role_features
(
  cid serial NOT NULL,
  roleid integer NOT NULL,
  featureid integer NOT NULL,
  read_write_access boolean DEFAULT false,
  CONSTRAINT fk_role_features_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_role_features_fk_1 FOREIGN KEY (featureid)
      REFERENCES fk_tblfeatures (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_role_features_fk_2 FOREIGN KEY (roleid)
      REFERENCES fk_tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_fk_role_features_role_feature UNIQUE (roleid , featureid )
)



insert into fk_tbluser(name,isadmin,password,email) values('admin',true,'sa','arun@greytip.com')

insert into fk_tbluser(name,isadmin,password,email) values('manager',true,'sa','arun@greytip.com')

insert into fk_tbluser(name,isadmin,password,email) values('employee',true,'sa','arun@greytip.com')

insert into fk_tblrole(name,description) values('admin','Administrator')

insert into fk_tblrole(name,description) values('Manager','Manager')

insert into fk_tblrole(name,description) values('employee','Employee')

insert into fk_user_roles(userid,roleid) values(4,1);

insert into fk_user_roles(userid,roleid) values(5,2);

insert into fk_user_roles(userid,roleid) values(6,3);

insert into fk_tblfeatures(description,code,enabled,isadmin,isemployee,ismanager) 
values('Home Page','pg_home',true,true,true,true)

insert into fk_tblfeatures(description,code,enabled,isadmin,isemployee,ismanager) 
values('Admin Page','pg_adm_home',true,true,false,false)

insert into fk_tblfeatures(description,code,enabled,isadmin,isemployee,ismanager) 
values('Manager Page','pg_mgr_home',true,true,false,true)

insert into fk_tblfeatures(description,code,enabled,isadmin,isemployee,ismanager) 
values('Employee Page','pg_emp_home',true,true,true,false)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(1,1,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(1,2,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(1,3,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(2,1,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(2,2,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(3,1,true)

insert into fk_role_features(roleid,featureid,read_write_access) 
values(3,3,true)



