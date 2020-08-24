Use Theater;
select count(Production.production_id) as ProductionCount, Actors.lastname,
Actors.firstname, Actors.surname
from Production join Roles on Production.production_id = Roles.production_id
join Actors on Roles.actor_id = Actors.actors_id
group by Actors.actors_id
having ProductionCount in (select max(ProductionCount) 
from (select count(Production.production_id) as ProductionCount, Actors.*
from Actors join Roles on Roles.actor_id = Actors.actors_id
join Production on Production.production_id = Roles.production_id
group by Actors.actors_id) as tmp)