const BASE = import.meta.env.VITE_API_BASE || 'http://localhost:8080/api';

export async function fetchAgents() {
  const res = await fetch(`${BASE}/agents`);
  if (!res.ok) throw new Error('Failed to fetch agents');
  return res.json();
}

export async function createAppointment(payload) {
  const res = await fetch(`${BASE}/appointments`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload),
  });
  if (!res.ok) {
    const err = await res.json().catch(() => ({}));
    throw new Error(err.error || 'Failed to create appointment');
  }
  return res.json();
}

export async function fetchAppointments() {
  const res = await fetch(`${BASE}/appointments`);
  if (!res.ok) throw new Error('Failed to fetch appointments');
  return res.json();
}
