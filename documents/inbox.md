# Constraints

- Do not _ever_ convert to floating point numbers!
- Do not _ever_ throw exceptions when operating on fractions!

# Add Fractions Test List

- 1/8 + 3/8 = 1/2    # lowest terms
- 1/5 + 3/5 = 4/5    # no reducing
- 3 + 5 = 8    # backwards compatible with integers
- ~~4 + 0 = 4~~    # no need to add
- ~~0 + 7 = 7~~
- ~~0 + 0 = 0~~    # kernel
- -8 + 4 = -4
- -1/7 + 3/7 = 2/7
- 3/7 + (-1/7) = 2/7
- 1/7 + 2/3 = 17/21    # bottoms are different
- 3/8 + 5/12 = 19/24    # bottoms are different and have a common factor
- 1/4 + 3/8 = 5/8    # one bottom is a multiple of the other

# Create Fractions Test List

- 5/0 (x)    # can't allow the bottom to be 0
- 0/0 (x)

# Fraction Equals Test List

- 1/2 = 4/8 = 5/10 = 9/18 = 182/364
- 1/3 = -1/-3
- -8/11 = 8/-11

# Questions

- If the fraction is negative, where should the `-` sign be? Top/numerator? or Bottom/denominator?
