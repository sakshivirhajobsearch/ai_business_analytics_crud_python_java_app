import matplotlib.pyplot as plt
import os

def plot_sales(df):
    plt.figure(figsize=(10, 5))
    plt.bar(df['title'], df['sales'])
    plt.xlabel("Report Title")
    plt.ylabel("Sales")
    plt.title("Sales by Report")
    plot_path = os.path.join("data", "sales_plot.png")
    plt.savefig(plot_path)
    return plot_path
