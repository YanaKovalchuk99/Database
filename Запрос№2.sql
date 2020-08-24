Use Theater;
explain select 
	count(actors_id)
from 
	Actors a 
    join Roles r on r.actor_id = a.actors_id
	join Team_performance tr on tr.role_id = r.role_id
	join Performance p on p.performance_id = tr.performance_id
where 
	p.performance_id = 9