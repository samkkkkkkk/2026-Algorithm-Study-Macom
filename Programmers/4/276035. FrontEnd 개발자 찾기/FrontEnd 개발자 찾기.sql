-- 코드를 작성해주세요
SELECT DISTINCT
    d.id,
    d.email,
    d.first_name,
    d.last_name
FROM skillcodes s
JOIN developers d
    ON (d.skill_code & s.code) > 0 
WHERE s.category = 'Front End'
ORDER BY d.id;