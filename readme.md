## @Async

<pre>
<strong>H2 Database</strong>

<strong>SQL Query</strong>

(SELECT CREATED_ON FROM EMPLOYEE ORDER BY CREATED_ON LIMIT 1) UNION ALL
(SELECT CREATED_ON FROM EMPLOYEE ORDER BY CREATED_ON DESC LIMIT 1)
<hr>
1M RECORDS - 10 THREADS
<pre>
CREATED_ON
xxxx-xx-xx 22:07:24.538
xxxx-xx-xx 22:08:18.989

TIME TAKEN: 54 seconds
</pre>
<hr>
1M RECORDS - 20 THREADS
<pre>
CREATED_ON
xxxx-xx-xx 22:12:25.157
xxxx-xx-xx 22:13:00.352

TIME TAKEN: 35 seconds
</pre>
</pre>