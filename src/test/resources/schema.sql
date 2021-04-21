DROP TABLE IF EXISTS dna;

--dna
create table dna(
	id int IDENTITY(1,1) primary key not null,
	dna varchar(1000),
	isMutant boolean
);

insert into dna ( dna, isMutant) values ( 'ATGATCTACTATGGGGCTAGCAATCTAATGCTGAAGTAGCAGGGTTATATGGGTAAACAGGTAA', true);
insert into dna ( dna, isMutant) values ( 'AAAATTTTCCCCGGGG', false);
insert into dna ( dna, isMutant) values ( 'AAAAATTTTTCCCCCGGGGGAAAAA', false);