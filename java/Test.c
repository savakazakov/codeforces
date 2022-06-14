#include <stdio.h>
#include <stdlib.h>
 
int minPowerToBeatCave(int* cave)
{
    int minPower = 0;
    int powerToBeatMonster = 0;
 
    for(int i = 1; i < cave[0] + 1; i++)
    {
        powerToBeatMonster = cave[i] - i + 2;
        
        if(powerToBeatMonster > minPower)
            minPower = powerToBeatMonster;
    }
 
    return minPower;
}
 
int cmpfunc(const void *caveA, const void *caveB)
{
    return minPowerToBeatCave(*(int **) caveA) - minPowerToBeatCave(*(int **) caveB);
}
 
int minPowerToWin(int** dungeon, int numOfCaves)
{
    qsort(dungeon, numOfCaves, 8, cmpfunc);
 
    int minPower = minPowerToBeatCave(dungeon[0]), curPower = minPowerToBeatCave(dungeon[0]);

    for(int i = 0; i < numOfCaves; i++)
    {
        if(curPower >= minPowerToBeatCave(dungeon[i]))
        {
            curPower += *dungeon[i];
        }
        else
        {
            minPower = minPowerToBeatCave(dungeon[i]) - curPower + minPower;
            curPower = minPowerToBeatCave(dungeon[i]);
            i -= 1;
        }
    }
 
    return minPower;
}
 
int main()
{
    int numOfTests = 0, numOfCaves = 0, numOfMonsters = 0;
 
    scanf("%d", &numOfTests);
 
    int answer[numOfTests];
 
    for(int i = 0; i < numOfTests; i++)
    {
        scanf("%d", &numOfCaves);
 
        int *arrayOfCaves[numOfCaves];
 
        for(int j = 0; j < numOfCaves; j++)
        {
            scanf("%d", &numOfMonsters);
            
            int *ptr = (int*) malloc(sizeof(int) * (numOfMonsters + 1));
            ptr[0] = numOfMonsters;
 
            for(int l = 1; l < numOfMonsters + 1; l++)
                scanf("%d", &ptr[l]);
 
            arrayOfCaves[j] = ptr;
        }
 
        answer[i] = minPowerToWin(arrayOfCaves, numOfCaves);
    }
 
    for (int i = 0; i < numOfTests; i++)
        printf("%d\n", answer[i]);
}