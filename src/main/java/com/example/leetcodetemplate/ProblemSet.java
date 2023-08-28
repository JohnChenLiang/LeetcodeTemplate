package com.example.leetcodetemplate;

import java.util.ArrayList;
import java.util.List;

//面试算法题。这个页面应该设计成接口吗？然后跳到实现类里？但这样就不能一眼看到代码了。。但代码全在一个页面也看不过来。
public class ProblemSet {
    //1.单例代码

    //2.LRU算法。最近最少使用（Least Recently Used, LRU）：
    //          这是一种基于时间的算法，它淘汰最近最久未被使用的数据。当新数据需要被缓存时，会优先替换掉最久未被访问的数据。


    //3.力扣 第2题 链表两数相加。链表相交 & 成环问题,160 相交链表，141 环形链表，142 环形链表2，61 旋转链表， 457 环形循环数组
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return l1;
    }

    //4.力扣 第5题 最长回文子串: 给你一个字符串 s，找到 s 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    public String longestPalindrome(String s) {
        return "";
    }

    //5.力扣 第22题 括号生成: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>();
    }

    //6.力扣 第23题 合并 K 个升序链表: 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        return lists[0];
    }

    //7.力扣 第42题 接雨水: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    public int trap(int[] height) {
        return 0;
    }

    //8.力扣 第46题 全排列: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        return new ArrayList<>();
    }

    //9.力扣 第51题 N 皇后: 回溯
    public List<List<String>> solveNQueens(int n) {
        return new ArrayList<>();
    }

    //10.力扣 第101题 对称二叉树: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
    public boolean isSymmetric(TreeNode root) {
        return true;
    }

    //11.力扣 第124题 二叉树中的最大路径和
    public int maxPathSum(TreeNode root) {
        return 0;
    }

    //12.力扣 第200题 岛屿数量： 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    public int numIslands(char[][] grid) {
        return 0;
    }

    //13.力扣 第206题 反转链表: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    public ListNode reverseList(ListNode head) {
        return head;
    }

    //14.力扣 第236题 二叉树的最近公共祖先: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root;
    }

    //15.力扣 第407题 接雨水 II(3D接雨水)
    public int trapRainWater(int[][] heightMap) {
        return 0;
    }

    //16.力扣 第901题 股票价格跨度
}





  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
