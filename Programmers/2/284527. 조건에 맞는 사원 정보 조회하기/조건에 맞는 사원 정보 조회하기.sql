-- 코드를 작성해주세요
SELECT  
    score,
    emp_no,
    emp_name,
    position,
    email
FROM 
    (
        SELECT
            SUM(g.score) AS score,
            e.emp_no,
            e.emp_name,
            e.position,
            e.email,
            DENSE_RANK() OVER(
                ORDER BY SUM(g.score) DESC
            ) AS ranking
        FROM hr_grade g
        JOIN hr_employees e
            ON g.emp_no = e.emp_no
        GROUP BY
            e.emp_no,
            e.emp_name,
            e.position,
            e.email
    ) t
WHERE ranking = 1;


