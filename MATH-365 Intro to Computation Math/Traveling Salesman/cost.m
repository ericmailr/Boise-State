function c = cost(s)
% Determines the cost (total distance) of state s using the norm
% function. Input s is a 2xn matrix where columns correspond to the
% coordinates of a state, with the first city repeated at the end.

s1 = s(:,1:end-1);
s2 = s(:,2:end);
c = sum(sqrt(sum(abs(s1-s2).^2,1)));

end
