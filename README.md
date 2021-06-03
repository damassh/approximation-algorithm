# Approximation Algorithm
<i>Advanced Algorithm Assignment 2</i>
<hr/>

## Vector Cover
1. Implement the greedy algorithm for the vertex cover problems
2. Implement the 2-approximation algorithm via maximal matchings for the vertex cover problem.
3. Design a new well performing algorithm for the vertex cover problem that has not been discussed during the lecture. Your algorithm should perform well on the instances listed in 4.There is not requirement regarding the worst-case approximation ratio.
4. Run all algorithms on the instance sets:
<ul>
    <li>frb30-15-mis (5 instances)</li>
    <li>frb35-17-mis (5 instances)</li>
    <li>frb40-19-mis (5 instances)</li>
</ul>

All the above (including random graphs) are available at
http://sites.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm
<li>frb30-15-mis.tar.gz (205 KB): 450 vertices (30 cliques) - 5 instances</li>
<li>frb35-17-mis.tar.gz (319 KB): 595 vertices (35 cliques) - 5 instances</li>
<li>frb40-19-mis.tar.gz (470 KB): 760 vertices (40 cliques) - 5 instances</li>
<li>You have to provide a table showing the results in terms of solution quality and runtimes. Compare the results of the different algorithms (1-2)
paragraphs).</li>

<hr/>

## Instruction
1. Clone the repository
2. Import the project in any Java IDE (preferably Intellij)
3. Run the `src.main.java.VertexCover.java`
4. This java class run 3 algorithms on Vertex Cover Problem - Greedy, Maximal Matching, and Vertex Support Algorithm
5. Output for all algorithms will be printed in console 