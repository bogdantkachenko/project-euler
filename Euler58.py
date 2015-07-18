#problem=58
top=100000
primes = [2,3,5,7]
for j in range(8, top):
    i = 0
    div = primes[i]
    while div**2<=j and j%div!=0 and i < len(primes)-1:
        i+=1
        div=primes[i]
    if j%div!=0:
        primes.append(j)

#print(primes)
print("primes array has been created")
def isprime(num):
    global primes
    if num <= primes[len(primes)-1]:
        if num in primes:
            return True
        else:
            return False
    else:
        i=0
        div = primes[i]
        while div**2<=num:
            if num%div==0:
                return False
            i+=1
            div = primes[i]
        return True
print(isprime(200011))

x,y,num=1,0,2
pd_cnt=0
ratio=1
size=1
while ratio>0.1:
    size+=2
    if isprime(size**2-size+1):
        pd_cnt+=1
    if isprime(size**2-2*size+2):
        pd_cnt+=1
    if isprime(size**2-3*size+3):
        pd_cnt+=1
    ratio=float(pd_cnt)/(2*size-1)
    print size, ', ', pd_cnt, ', ', ratio

#print size, ' , ', pd_cnt, ' , ', ratio
#print(diag_p)