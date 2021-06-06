package com.misis;

import java.util.Scanner;

class PermutationsWithoutRepetition {
    static int num = 1; // номер размещения

    public static void swap(int i, int j, int ...a){
        int s = a[i];
        a[i] = a[j];
        a[j] = s;
    }

    public static boolean NextSet(int n, int m,int ...a){
        int j;
        do  // повторяем пока не будет найдено следующее размещение
        {
            j = n - 2;
            while (j != -1 && a[j] >= a[j + 1]) j--;
            if (j == -1)
                return false; // больше размещений нет
            int k = n - 1;
            while (a[j] >= a[k]) k--;
            swap(j, k, a);
            int l = j + 1, r = n - 1; // сортируем оставшуюся часть последовательности
            while (l < r)
                swap(l++, r--, a);
        } while (j > m - 1);
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
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i + 1;
        Print(m, a);
        while (NextSet(n, m, a))
            Print(m, a);
    }
}
