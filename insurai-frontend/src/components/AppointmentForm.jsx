import React, { useEffect, useState } from 'react';
import { fetchAgents, createAppointment } from '../api';

export default function AppointmentForm() {
  const [agents, setAgents] = useState([]);
  const [agentId, setAgentId] = useState('');
  const [agentName, setAgentName] = useState('');
  const [date, setDate] = useState('');
  const [time, setTime] = useState('09:00');
  const [reason, setReason] = useState('');
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState(null);

  useEffect(() => {
    fetchAgents()
      .then(setAgents)
      .catch(err => {
        console.error(err);
        setMessage({ type: 'error', text: 'Failed to load agents' });
      });
  }, []);

  useEffect(() => {
    const sel = agents.find(a => String(a.id) === String(agentId));
    setAgentName(sel ? sel.name : '');
  }, [agentId, agents]);

  function buildDateTime() {
    // The backend expects an ISO-like local datetime string (no timezone):
    // "YYYY-MM-DDTHH:mm:00"
    if (!date || !time) return null;
    return `${date}T${time}:00`;
  }

  // Simple time slots generator (09:00 - 17:00 every 30 min)
  function timeSlots() {
    const slots = [];
    for (let h = 9; h <= 16; h++) {
      slots.push(`${String(h).padStart(2, '0')}:00`);
      slots.push(`${String(h).padStart(2, '0')}:30`);
    }
    slots.push('17:00');
    return slots;
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setMessage(null);
    const dt = buildDateTime();
    if (!agentId || !dt) {
      setMessage({ type: 'error', text: 'Please choose an agent, date and time.' });
      return;
    }

    const payload = {
      agentId: Number(agentId),
      agentName,
      preferredDateTime: dt,
      reason,
      // Optionally send user info here if you have it:
      // userId: currentUserId,
      // userName: currentUserName
    };

    try {
      setLoading(true);
      const res = await createAppointment(payload);
      setMessage({ type: 'success', text: `Appointment created (id: ${res.id})` });
      // clear form
      setAgentId('');
      setAgentName('');
      setDate('');
      setTime('09:00');
      setReason('');
    } catch (err) {
      setMessage({ type: 'error', text: err.message });
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="max-w-xl mx-auto p-6 bg-white rounded-2xl shadow-md">
      <h2 className="text-2xl font-semibold mb-4">Schedule an Appointment</h2>

      {message && (
        <div className={`mb-4 p-3 rounded ${message.type === 'error' ? 'bg-red-50 border border-red-200' : 'bg-green-50 border border-green-200'}`}>
          {message.text}
        </div>
      )}

      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block text-sm font-medium mb-1">Agent</label>
          <select
            value={agentId}
            onChange={e => setAgentId(e.target.value)}
            className="w-full border rounded p-2"
            required
          >
            <option value="">-- Select an agent --</option>
            {agents.map(a => <option key={a.id} value={a.id}>{a.name}</option>)}
          </select>
        </div>

        <div className="grid grid-cols-2 gap-2">
          <div>
            <label className="block text-sm font-medium mb-1">Date</label>
            <input
              type="date"
              value={date}
              onChange={e => setDate(e.target.value)}
              className="w-full border rounded p-2"
              required
            />
          </div>

          <div>
            <label className="block text-sm font-medium mb-1">Time slot</label>
            <select
              value={time}
              onChange={e => setTime(e.target.value)}
              className="w-full border rounded p-2"
              required
            >
              {timeSlots().map(s => <option key={s} value={s}>{s}</option>)}
            </select>
          </div>
        </div>

        <div>
          <label className="block text-sm font-medium mb-1">Reason</label>
          <textarea
            value={reason}
            onChange={e => setReason(e.target.value)}
            rows={4}
            className="w-full border rounded p-2"
            placeholder="Brief reason for appointment"
          />
        </div>

        <div>
          <button
            type="submit"
            disabled={loading}
            className="px-4 py-2 rounded bg-indigo-600 text-white"
          >
            {loading ? 'Scheduling...' : 'Schedule Appointment'}
          </button>
        </div>
      </form>
    </div>
  );
}
