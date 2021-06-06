package com.misis;

import java.util.Scanner;

class PermutationWithRepetition {
    static int num = 1; // номер размещения


    public static boolean NextSet(int n, int m,int ...a){
        int j = m - 1;
        while (j >= 0 && a[j] == n) j--;
        if (j < 0) return false;
        if (a[j] >= n)
            j--;
        a[j]++;
        if (j == m - 1) return true;
        for (int k = j + 1; k < m; k++)
            a[k] = 1;
        return true;
    }

    public static void Print(int n, int ...a)  // вывод размещения
    {
        System.out.print(num++ +": ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");//cout << a[i] << " ";
        System.out.println();
    }

    public static void main(String[] args) {
        int n, m;
        int[] a;
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        n = sc.nextInt();
        System.out.print("M = ");
        m = sc.nextInt();
        int h = n > m ? n : m; // размер массива а выбирается как max(n,m)
        a = new int[h];
        for (int i = 0; i < h; i++)
            a[i] = 1;
        Print(m, a);
        while (NextSet(n, m, a))
            Print(m, a);
    }
}
