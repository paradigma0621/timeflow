package com.paradigma0621.timeflow.model;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.List;

public class TreeViewExplorer {

    /**
     * Returns a cell for the tree item given. Or null.
     *
     * @param treeItem tree item
     * @param treeView tree view
     * @return tree cell
     */
    public static TreeCell findCellByItem(TreeItem treeItem, TreeView treeView) {
        return recursiveFindCellByItem(treeItem, treeView);
    }

    private static TreeCell recursiveFindCellByItem(TreeItem treeItem, Node node) {

        if (node.getStyleClass().contains("tree-cell")
                && TreeCell.class.isAssignableFrom(node.getClass())
                && ((TreeCell) node).getTreeItem() == treeItem)
            return (TreeCell) node;

        if (!Parent.class.isAssignableFrom(node.getClass()))
            return null;

        List<Node> nodes = ((Parent) node).getChildrenUnmodifiable();
        if (nodes == null) return null;

        for (Node n : nodes) {
            TreeCell cell = recursiveFindCellByItem(treeItem, n);
            if (cell != null) return cell;
        }
        return null;
    }
}