======================================
========= ���� �ڵ� ==================
create table pdt_type_code(
    pdt_type number not null,
    type_name varchar2(20) not null,
    constraints pk_pdt_type primary key(pdt_type)
);

insert into PDT_TYPE_CODE values(1,'type1');
insert into PDT_TYPE_CODE values(2,'type2');

update pdt_type_code set type_name = '��ǰ' where pdt_type = 1;

delete from pdt_type_code where pdt_type = 2;

select * from pdt_type_code;

===========================================
========= �� ���� �ڵ� ==================
create table target_code(
    target number not null,
    target_name varchar2(20) not null,
    constraints pk_target primary key(target)
);
insert into target_code values(1,'target1');
insert into target_code values(2,'target2');

update target_code set type_name = '����' where pdt_type = 1;

delete from target_code where pdt_type = 2;

select * from target_code;

create table cocompany(
     coc_name varchar2(100) not null,
     pdt_type number not null,
     pwd varchar2(50) not null,
     empno number(10) not null,
     coc_emp varchar2(20)not null,
     coc_call varchar2(20),
     coc_mail varchar2(100),
     constraints pk_cocompany primary key(coc_name, pdt_type),
     constraints fk_cocompany foreign key (pdt_type) references pdt_type_code(pdt_type)
);
create table purposal(
pdt_name varchar2(100),
reg_date date not null,
ins_date date default sysdate not null,
upd_date date default sysdate not null,
writer varchar2(20) not null,
pdt_type number not null,
bigo varchar2(1000),
target varchar2(100) not null,
pic varchar2(100),
del_ck number(10) default 0 not null ,  
constraints pk_purposal primary key(pdt_name),
constraints fk1_purposal foreign key(pdt_type) references pdt_type_code(pdt_type)
);
create table samp(
 samp_id varchar2(50),
 arriv_date date not null,
 writer varchar2(20) not null,
 price number(10) not null,
 bigo varchar2(1000),
 pic varchar2(50),
 coc_name varchar2(100) not null,
 pdt_name varchar2(100) not null,
 pdt_type number not null,
 ins_date date default sysdate,
 upd_date date default sysdate,
 del_ok number(10) default 0 not null ,
 constraints pk_samp primary key(samp_id),
 constraints fk_samp foreign key (pdt_name) references purposal(pdt_name),
 constraints fk_samp2 foreign key (coc_name,pdt_type) references cocompany(coc_name,pdt_type)
);



===========================================================

drop table samp;
drop table cocompany;
drop table purposal;
drop table pdt_type_code;
drop table target_code;


create table cocompany(
     coc_name varchar2(100) not null,
     pdt_type varchar2(20) not null,
     pwd varchar2(50) not null,
     empno number(10) not null,
     coc_emp varchar2(20)not null,
     coc_call varchar2(20),
     coc_mail varchar2(100),
     constraints pk_cocompany primary key(coc_name, pdt_type)
);

create table purposal(
pdt_name varchar2(100),
reg_date date not null,
ins_date date default sysdate,
upd_date date default sysdate,
writer varchar2(20) not null,
pdt_type varchar2(20) not null,
bigo varchar2(1000),
target varchar2(20) not null,
pic varchar2(100),
del_ck number(10) default 0 not null ,  
orgpic varchar2(100),
constraints pk_purposal primary key(pdt_name)
);

create table samp(
 samp_id varchar2(50),
 arriv_date date not null,
 writer varchar2(20) not null,
 price number(10) not null,
 bigo varchar2(1000),
 pic varchar2(50),
 coc_name varchar2(100) not null,
 pdt_name varchar2(100) not null,
 pdt_type varchar2(20) not null,
 ins_date date default sysdate,
 upd_date date default sysdate,
 del_ok number(10) default 0 not null ,
 constraints pk_samp primary key(samp_id),
 constraints fk_samp foreign key (pdt_name) references purposal(pdt_name),
 constraints fk_samp2 foreign key (coc_name,pdt_type) references cocompany(coc_name,pdt_type)
);
