
fprintf('         %s            \n','SWAP 2 PAIRS');
fprintf('|      %s       | %s |','Cost','Iterations');
fprintf('\n--------------------------------\n');
for i = 1:10
    fprintf('| %2.12f |   %6d   |\n',costVec2(i,1),costVec2(i,2));
end
fprintf('\n %s %2.12f  \n %s %6d ','Avg Cost: ',mean(costVec2(:,1)),'Avg Iter: ',round(mean(costVec2(:,2))))
%}
%{
relErr = zeros(10,1);
for i = 1:10
    relErr(i) = (costVec(i)-100)/100;
end
relErr;
    %}
%{
costVec2 = zeros(10,2);
for j = 1:10
        [c,kSolution,~,~] = SA(xx,yy,5,0.99981,0,5e4,10e-6);
        costVec2(j,1) = c;
        costVec2(j,2) = kSolution;
end
%}