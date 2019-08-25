184. Department Highest Salary

Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');


select d.Name as Department, e.Name as Employee, t.Salary from Employee e,
(select DepartmentId, max(Salary) as Salary from Employee group by DepartmentId) t,Department d 
where t.DepartmentId = e.DepartmentId and e.Salary = t.Salary and e.DepartmentId = d.Id; 




185. Department Top Three Salaries

Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;

delete from Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '75000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '50000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '75000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '60000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '50000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '40000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('8', 'Wi', '75000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Jet', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Rndy', '50000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Pill', '40000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('8', 'Lills', '75000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('9', 'bills', '75000', '2');

Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');


#解法一
select d.Name as Department, e.Name as Employee, 
e.Salary from Employee e 
 left join
(select case when max(e2.Salary) is not null then max(e2.Salary) 
 when max(e2.Salary) is null then 0 end as Salary, e2.DepartmentId from Employee e2,
(select max(e1.Salary) as Salary, e1.DepartmentId from Employee e1,
(select max(Salary) as Salary, DepartmentId from Employee group by DepartmentId) t 
where e1.Salary < t.Salary and e1.DepartmentId = t.DepartmentId group by DepartmentId) t1
where e2.Salary < t1.Salary and e2.DepartmentId = t1.DepartmentId group by DepartmentId) t2
on e.DepartmentId = t2.DepartmentId, Department d
where (e.Salary >= t2.Salary or t2.Salary is null) and d.Id = e.DepartmentId order by d.Id, e.Salary desc;
 

#解法二
select d.Name as Department, y.Name as Employee, y.Salary from (
Select Name , Salary,
@curRank := IF(@preDep = (@preDep := DepartmentId), 
                  @curRank + (@prevScore <> (@prevScore := Salary)),
                  (@preDep := DepartmentId) & (@prevScore := Salary) & 0
              ) as Rank
from Employee,
(Select @curRank := 0, @prevScore := -1,@preDep := 0) r
 Order by DepartmentId, Salary DESC) y,
Department d
where y.Rank < 3 and y.DepartmentId = d.Id order by d.Id, y.Salary desc;



626. Exchange Seats

Create table If Not Exists seat(id int, student varchar(255));
Truncate table seat;
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
insert into seat (id, student) values ('5', 'Jeames');



#解法一
select a.Id, case 
when a.Id = b.con and a.Id % 2 = 1 then a.student
when a.Id <> b.con and  a.Id % 2 = 1 then c.student
when a.Id % 2 = 0 then d.student
end as student
from seat a  left join seat c on a.Id = c.Id - 1 left join seat d on a.Id = d.Id + 1,(select count(Id) as con from seat) b 
order by a.Id;

#解法二
select 
IF(Id < (select count(Id) from seat), If(Id mod 2 = 1, Id + 1, Id - 1), IF(Id mod 2 = 0, Id - 1, Id)) as Id, 
student from seat order by Id;
