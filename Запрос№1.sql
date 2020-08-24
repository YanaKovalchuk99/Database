Use Theater;
select d.director_id, d.lastname, d.firstname, d.surname, d.phone
from Director d inner join production pr on pr.director_id = d.director_id
inner join Performance p on p.production_id = pr.production_id
inner join Team_performance t on t.performance_id = p.performance_id
inner join Roles r on r.role_id = t.role_id
inner join Role_in_the_play ri on ri.role_in_the_play_id = r.role_in_the_play_id
inner join Role_type rt on rt.role_type_id = ri.role_type_id
inner join Actors a on a.actors_id = r.actor_id
where p.performance_id = 25 and a.actors_id = 521 and rt.role_type_id = 1