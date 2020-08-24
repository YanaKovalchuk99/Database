Use Theater;
select Count(performance_id) as PerformanceCount, performance_name
from Performance p inner join production pr on pr.production_id = p.production_id
inner join Play pl on pl.play_id = pr.play_id
group by pl.play_id