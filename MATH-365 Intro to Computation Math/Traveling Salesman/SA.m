function [cbest,kSol,k,sbest] = SA(xdata,ydata,T0,B,goal,kCheck,tempMin)
% Runs a simple Simulated Annealing algorithm for solving Traveling
% Salesman Problems. 
% INPUT:
% xdata = x coordinates of each city in a horizontal array
% ydata = y coordinates of each city in a horizontal array
% T0 = Initial Temp, B = Cooling Constant
% Goal = Stopping Cost
% kCheck = # of iterations after which to check if new solution was found
% tempMin = Minimum Temperature to reach before stopping
% OUTPUT:
% cbest = cost of the best found solution state
% kSol = iteration at which the best solution was found
% k = total iterations actually performed
% sbest = matrix of coordinates in order of best route
% Example Data:
%xx = [0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9];
%yy = [0 1 2 3 4 5 6 7 8 9 9 8 7 6 5 4 3 2 1 0 0 1 2 3 4 5 6 7 8 9 9 8 7 6 5 4 3 2 1 0 0 1 2 3 4 5 6 7 8 9 9 8 7 6 5 4 3 2 1 0 0 1 2 3 4 5 6 7 8 9 9 8 7 6 5 4 3 2 1 0 0 1 2 3 4 5 6 7 8 9 9 8 7 6 5 4 3 2 1 0];

n = length(xdata); % # of cities
% Define starting points
x1 = xdata(:,1);
y1 = ydata(:,1);
% Remove starting point from data that will be rearranged
xdata(:,1)=[];
ydata(:,1)=[];
% Make a random permutation of the cities, excluding the first
z = randperm(n-1);
xdata = xdata(z);
ydata = ydata(z);
% Add starting city back to beginning and end
s0 = [x1 xdata x1;y1 ydata y1];
sbetter = s0;
cbest = cost(s0);
clastbest = cbest;
stop = false;
changeCount = 0;
count = 0;
k = 0;
T = T0;
while T > tempMin && cbest > goal && ~stop
    % Switch 2 random points
    snew = switchCities(sbetter);
    
    % Option to switch another pair of points:
    %snew = switchCities(snew);
    
    cbetter = cost(sbetter);
    d = (cost(snew) - cbetter)/cbetter;
    P = aprobfun(d,T);
    randomfrac = rand(1);
    if randomfrac <= P 
        sbetter = snew;
        T = T * B;
        changeCount = changeCount + 1;
    end         
    k = k + 1;       
    if cbetter<cbest
        cbest = cbetter;
        sbest = sbetter;
        kSol = k;
    end
    % Check if a new sbest has been found within specified # of iterations
    if mod(k,kCheck)==0
        if clastbest == cbest
            stop = true;
        end
        clastbest = cbest;  
    end
    % Real time plotting of solutions
    if mod(k,500)==0
    hold off
    pause(eps)
    scatter(s0(1,:),s0(2,:))
    axis ([min(s0(1,:))-1,max(s0(1,:))+1,min(s0(2,:))-1,max(s0(2,:))+1])
    hold on
    plot(sbetter(1,:),sbetter(2,:),'g') 
    str1 = sprintf('Cost = %5.4f                 ChangeCount = %d',cost(sbetter),changeCount);
    str2 = sprintf('Iteration = %d            Temp = %2.2e',k,T);
    xlabel(str2)
    title(str1)
    end
    %}
    % create arrays for plotting solution cost progress
     if mod(k,500)==0
         count = count + 1;
    ccbest(count) = cbetter;
    kk(count) = k;   
    TT(count) = T;
    end
    %}
end
% Plot of solution and temp progress
hold off
figure;
subplot(1,2,1)
plot(kk,ccbest,kk,goal,'g')
axis([-inf, inf, goal - 1, inf]);
title('Solution Cost vs K Iterations')
xlabel('k')
ylabel('Cost')
legend('Solution Cost','Global Optimum')
subplot(1,2,2)
semilogy(kk,TT,'r')
title('Temperature vs K Iterations')
xlabel('k')
ylabel('Temperature')
% Plot of final solution
figure;
scatter(s0(1,:),s0(2,:))
axis ([min(s0(1,:))-1,max(s0(1,:))+1,min(s0(2,:))-1,max(s0(2,:))+1])
hold on
plot(sbest(1,:),sbest(2,:),'g') 
str1 = sprintf('Cost = %5.4f                 ChangeCount = %d',cost(sbest),changeCount);
str2 = sprintf('Iteration = %d            Temp = %2.2e',k,T);
xlabel(str2)
title(str1)
%}
end