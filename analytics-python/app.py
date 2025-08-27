from flask import Flask, request, jsonify

app = Flask(__name__)

# In-memory data store (for demo purposes)
analytics_data = []
next_id = 1

@app.route('/')
def home():
    return "📊 Welcome to the AI Business Analytics CRUD App!"

# CREATE
@app.route('/api/data', methods=['POST'])
def create_data():
    global next_id
    new_data = request.get_json()
    new_data['id'] = next_id
    analytics_data.append(new_data)
    next_id += 1
    return jsonify({"message": "Data created", "data": new_data}), 201

# READ (all)
@app.route('/api/data', methods=['GET'])
def get_all_data():
    return jsonify(analytics_data), 200

# READ (one)
@app.route('/api/data/<int:data_id>', methods=['GET'])
def get_data_by_id(data_id):
    for item in analytics_data:
        if item['id'] == data_id:
            return jsonify(item), 200
    return jsonify({"error": "Data not found"}), 404

# UPDATE
@app.route('/api/data/<int:data_id>', methods=['PUT'])
def update_data(data_id):
    updated_data = request.get_json()
    for item in analytics_data:
        if item['id'] == data_id:
            item.update(updated_data)
            return jsonify({"message": "Data updated", "data": item}), 200
    return jsonify({"error": "Data not found"}), 404

# DELETE
@app.route('/api/data/<int:data_id>', methods=['DELETE'])
def delete_data(data_id):
    global analytics_data
    analytics_data = [item for item in analytics_data if item['id'] != data_id]
    return jsonify({"message": f"Data with id {data_id} deleted"}), 200

if __name__ == '__main__':
    app.run(port=5001)
