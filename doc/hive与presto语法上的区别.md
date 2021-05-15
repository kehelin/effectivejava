-hive与presto在使用时要注意语法上的区别

`
select dt as
version,tid,
       split(tid,'_')[0] as z,
       split(tid,'_')[1] as x,
       split(tid,'_')[2] as y,
       to_base64(tvalue)
  from app_maprender.vector_tiles
 where dt='20190922Test0-8'
   and dv='20190922Test0-8'
   `
在hive可正常执行，但在presto下回导致如下错误，
com.facebook.presto.spi.PrestoException: SQL array indices start at 1

hive中的array是从0开始，而在presto中是从1开始

Subscript Operator: []
The [] operator is used to access an element of an array and is indexed starting from one:

hive中base64编码函数为base64(),presto的为to_base64()