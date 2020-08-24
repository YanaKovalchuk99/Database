Use Theater;
select count(production_id) as ProductionCount, ActorsCount
from (select Production.production_id, count(actors_id) as ActorsCount
from Production
join Roles on Production.production_id = Roles.production_id
join Actors on Actors.actors_id = Roles.actor_id 
group by production_id) as tmp
group by ActorsCount