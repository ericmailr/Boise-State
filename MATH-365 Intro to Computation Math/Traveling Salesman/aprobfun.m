function P = aprobfun(d,T)
% Acceptance probability function - returns probability that a new state
% will be accepted given the relative change in cost and current temperature.
% d = (cost of new state - cost of current state)/cost of current state
% T = current temperature

if d <= 0
    P = 1;
elseif d > 0
    P = exp(-d/T);
end