Use Theater;
explain select count(Production.production_id) as ProductionCount, Actors.lastname,
Actors.firstname, Actors.surname
from Production join Roles on Production.production_id = Roles.production_id
join Actors on Roles.actor_id = Actors.actors_id
group by Actors.actors_id
having ProductionCount > (select count(Production.production_id) as ProductionCount
from Production join Roles on Production.production_id = Roles.production_id
join Actors on Roles.actor_id = Actors.actors_id
where Actors.actors_id = 35)