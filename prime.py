import math

def is_prime(num):
    divisors = range(2, int(math.sqrt(num)) + 1)
    remainders = filter(lambda x: num % x == 0, divisors)
    return len(remainders) == 0

print is_prime(1), 1
print is_prime(5), 5
print is_prime(8), 8
print is_prime(13), 13
print is_prime(18), 18
print is_prime(21), 21
print is_prime(37), 37
