function f = switchCities(cities)
% switches order of two random cities for Simulated Annealing
% cities: 2xn matrix containing looped city coordinates

n = length(cities(1,:)) - 1;
p1ind = randi(n-1)+1;
p2ind = randi(n-1)+1;
snew = cities;
snew(:,[p1ind p2ind]) = snew(:,[p2ind p1ind]);
f = snew;