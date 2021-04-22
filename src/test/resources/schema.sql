DROP TABLE IF EXISTS dna;

--dna
create table dna(
	id int IDENTITY(1,1) primary key not null,
	dna varchar(1000),
	is_Mutant boolean
);

insert into dna ( dna, is_Mutant) values ( 'ATGATCTACTATGGGGCTAGCAATCTAATGCTGAAGTAGCAGGGTTATATGGGTAAACAGGTAA', true);
insert into dna ( dna, is_Mutant) values ( 'AAAATTTTCCCCGGGG', false);
insert into dna ( dna, is_Mutant) values ( 'AAAAATTTTTCCCCCGGGGGAAAAA', false);