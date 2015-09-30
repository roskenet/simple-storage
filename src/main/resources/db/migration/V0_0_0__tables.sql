CREATE TABLE image (
    id UUID PRIMARY KEY,
    created_date TIMESTAMP DEFAULT now(),
    created_by TEXT DEFAULT 'UNKNOWN',
    last_modified_date TIMESTAMP DEFAULT now(),
    last_modified_by TEXT DEFAULT 'UNKNOWN',
    title TEXT,
    status TEXT DEFAULT 'NODATA',
    size INTEGER DEFAULT 0,
    mimetype TEXT
);

CREATE TABLE tag (
    id TEXT PRIMARY KEY,
    created_date TIMESTAMP DEFAULT now(),
    created_by TEXT DEFAULT 'UNKNOWN',
    last_modified_date TIMESTAMP DEFAULT now(),
    last_modified_by TEXT DEFAULT 'UNKNOWN'
);

CREATE TABLE image_tags (
    image_id UUID REFERENCES image (id) ON DELETE CASCADE,
    tags_id TEXT REFERENCES tag (id) ON DELETE CASCADE
);

CREATE INDEX ON image_tags (image_id);
CREATE INDEX ON image_tags (tags_id);