Use Theater;
explain select count(p.performance_id) as PerformanceCount, Actors.lastname,
Actors.firstname, Actors.surname
from Performance p
join Team_performance tp on tp.performance_id = p.performance_id
join Roles on tp.role_id = Roles.role_id
join Actors on Roles.actor_id = Actors.actors_id
group by Actors.actors_id
having PerformanceCount in (select max(PerformanceCount) 
from (select count(p.performance_id) as PerformanceCount, Actors.*
from Performance p
join Team_performance tp on tp.performance_id = p.performance_id
join Roles on tp.role_id = Roles.role_id
join Actors on Roles.actor_id = Actors.actors_id
group by Actors.actors_id) as tmp)