### About Lost Silence
A ontology-based tragdy early-alert simulation. 
Based on a knowledge base of cellular network management system, the sign of tragdy could be detected by continuously processing the cellular network data stream

## Tools Required
C-SPARQL, jena, java.util.concurrent

## Lost Silence v2.0 Introduction
### UEStreamGenerator.java
Create a data stream for one geo-pixel.
### CSPARQL_Engine.java
Execute the C-SPARQL query, and give the query result. Each query takes one thread.
