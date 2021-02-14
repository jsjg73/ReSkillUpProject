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

insert into samp ( samp_id, arriv_date, writer, price, pic, orgpic,coc_name, pdt_name, bigo,pdt_type)
values ('u3',to_date('02/11/2021 00:00:00', 'mm/dd/yyyy hh24:mi:ss'),'admin',100,'','','제조사1','c1','','전자기기')

--제조사 로그인 기획서 목록 조회
select count(*)
from purposal p,
(select pdt_type from SCOTT.COCOMPANY where coc_name = '제조사1') c
where p.pdt_type = c.pdt_type