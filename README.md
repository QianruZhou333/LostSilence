# Lost Silence
A ontology-based tragdy early-alert simulation. 
Based on a knowledge base of cellular network management system, the sign of tragdy could be detected by continuously processing the cellular network data stream

为了纪念2015年6月1日晚上9时30分左右发生在中国湖北监利县长江水域的“东方之星”沉船事件中丧生的400多人，我们提出了通过利用本体构建的通信网知识图谱, 实时检测到沉船事件并上报的算法 "Lost Silence (消失的沉寂)"。详情请见发表于2017年的 ISWC conference WSP workshop的文章:

#### Q. Zhou, S. McLaughlin, A.J.G. Gray, S. Wu, C. Wang, "Lost Silence: An emergency response early detection service through continuous processing of telecommunication data streams," In Proc. ISWC WSP 2017, Vienna, Austria, pp. 33--42.

## Tools Required
C-SPARQL, jena, java.util.concurrent

## Lost Silence v2.0 Introduction
### UEStreamGenerator.java
Create a data stream for one geo-pixel.
### CSPARQL_Engine.java
Execute the C-SPARQL query, and give the query result. Each query takes one thread.
