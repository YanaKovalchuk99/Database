Use Theater;
select count(actor_id) as ActorCount, RolesCount
from (select  Roles.actor_id, count(role_id) as RolesCount
from Roles join Actors on Actors.actors_id = Roles.actor_id 
group by actor_id) as tmp
group by RolesCount